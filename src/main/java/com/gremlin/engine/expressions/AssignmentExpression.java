package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

public class AssignmentExpression extends Expression
{
    private Expression target;
    private AssignmentKind kind;
    private Expression value;

    public AssignmentExpression(Expression target, AssignmentKind kind, Expression value) {
        this.target = target;
        this.kind = kind;
        this.value = value;    
    }

    @Override
    public ExpressionResult Evaluate(Processor processor) {

        switch(this.kind)
        {
            case ASSIGN:

                break;
            case PLUSASSIGN:

                break;
            case MINUSASSIGN:

                break;
        }
        
        return ExpressionResult.forEmpty();
    }
}

