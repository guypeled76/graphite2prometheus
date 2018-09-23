package com.gremlin.engine;

import com.gremlin.engine.expressions.*;
import com.gremlin.apps.ArithmeticBaseVisitor;
import com.gremlin.apps.ArithmeticParser.*;


class ExpressionBuilder extends ArithmeticBaseVisitor<Expression>
{

   

    public ExpressionBuilder() {
        
    }

    @Override
    public Expression visitAssignment(AssignmentContext ctx) {
        return new AssignmentExpression(
            this.visitVariable(ctx.variable()),
            AssignmentKind.ASSIGN,
            this.visitExpression(ctx.expression())
        );
    }

    @Override
    public Expression visitPlusAssignment(PlusAssignmentContext ctx) {
        return new AssignmentExpression(
            this.visitVariable(ctx.variable()),
            AssignmentKind.PLUSASSIGN,
            this.visitExpression(ctx.expression())
        );
    }

    @Override
    public Expression visitMinusAssignment(MinusAssignmentContext ctx) {
        return new AssignmentExpression(
            this.visitVariable(ctx.variable()),
            AssignmentKind.MINUSASSIGN,
            this.visitExpression(ctx.expression())
        );
    }

    @Override
    public Expression visitParentheses(ParenthesesContext ctx) {
        return new ParenthesesExpression(
          this.visitExpression(ctx.expression())  
        );
    }

    @Override
    public Expression visitSimpleNumber(SimpleNumberContext ctx) {
        return new NumberExpression(
            Float.parseFloat(ctx.getText())
        );
    }

    @Override
    public Expression visitHexNumber(HexNumberContext ctx) {
        return new NumberExpression(
            Long.parseLong(ctx.hexString().getText(), 16)
        );
    }

    @Override
    public Expression visitScientificNumber(ScientificNumberContext ctx) {
        return new NumberExpression(
            Float.parseFloat(ctx.simpleNumber(0).getText()),
            Float.parseFloat(ctx.simpleNumber(1).getText())
        );
    }

    @Override
    public Expression visitMinusNumber(MinusNumberContext ctx) {
        return new NumberExpression(
            Float.parseFloat(ctx.simpleNumber().getText()) * -1
        );
    }
    
    @Override
    public Expression visitVariable(VariableContext ctx) {        
        return new VariableExpression(ctx.getText());
    }

    @Override
    public Expression visitMinusminusVariable(MinusminusVariableContext ctx) {
        return new UnaryExpression(this.visitVariable(ctx.variable()), UnaryKind.PREMINUSMINUS);
    }

    @Override
    public Expression visitVariableMinusminus(VariableMinusminusContext ctx) {
        return new UnaryExpression(this.visitVariable(ctx.variable()), UnaryKind.POSTMINUSMINUS);
    }

    @Override
    public Expression visitPlusplusVariable(PlusplusVariableContext ctx) {
        return new UnaryExpression(this.visitVariable(ctx.variable()), UnaryKind.PREPLUSPLUS);
    }

    @Override
    public Expression visitVariablePlusplus(VariablePlusplusContext ctx) {
        return new UnaryExpression(this.visitVariable(ctx.variable()), UnaryKind.POSTPLUSPLUS);
    }

    @Override
    public Expression visitMinusVariable(MinusVariableContext ctx) {
        return new UnaryExpression(this.visitVariable(ctx.variable()), UnaryKind.MINUS);
    }

    @Override
    public Expression visitDivisionTerm(DivisionTermContext ctx) {
        return new BinaryExpression(
            this.visitFactor(ctx.factor()),
            BinaryKind.DEVISION,
            this.visitTerm(ctx.term())
        );
    }

    @Override
    public Expression visitMultiplicationTerm(MultiplicationTermContext ctx) {
        return new BinaryExpression(
            this.visitFactor(ctx.factor()),
            BinaryKind.MULTIPLICATION,
            this.visitTerm(ctx.term())
        );
    }

    @Override
    public Expression visitModuloTerm(ModuloTermContext ctx) {
        return new BinaryExpression(
            this.visitFactor(ctx.factor()),
            BinaryKind.MODULO,
            this.visitTerm(ctx.term())
        );
    }

    @Override
    public Expression visitPowerFactor(PowerFactorContext ctx) {
        return new BinaryExpression(
            this.visitAtom(ctx.atom()),
            BinaryKind.POWER,
            this.visitFactor(ctx.factor())
        );
    }

    @Override
    public Expression visitAdditionExpression(AdditionExpressionContext ctx) {
        return new BinaryExpression(
            this.visitTerm(ctx.term()),
            BinaryKind.ADDITION,
            this.visitExpression(ctx.expression())
        );
    }

    @Override
    public Expression visitSubtractionExpression(SubtractionExpressionContext ctx) {
        return new BinaryExpression(
            this.visitTerm(ctx.term()),
            BinaryKind.SUBTRACTION,
            this.visitExpression(ctx.expression())
        );
    }
}

