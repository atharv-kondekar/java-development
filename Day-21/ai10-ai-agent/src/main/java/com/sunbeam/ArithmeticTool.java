package com.sunbeam;

import org.springframework.expression.Expression;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticTool {

	@Tool(description = "Solves arithmetic expression and return result. If expression is invalid return result")
	public String solveArithmeticExpression(String expr) {
		try {
			System.out.println("Solving Arithmetic Expression : "+expr);

			SpelExpressionParser parser = new SpelExpressionParser();
			Expression expression = parser.parseExpression(expr);

			Object result = expression.getValue();
			System.out.println("Result = "+result);

			return result.toString();
		} catch (Exception e) {
			return "Error: "+e.getMessage();
		}
	}
}
