package com.gremlin.engine;

import com.gremlin.apps.ArithmeticBaseVisitor;
import com.gremlin.apps.ArithmeticParser.ContentContext;


class ExpressionBuilder extends ArithmeticBaseVisitor<Expression>
{

   

    public ExpressionBuilder() {
        
    }


    
    @Override
    public Expression visitContent(ContentContext ctx) {
        return super.visitContent(ctx);
    }
}

