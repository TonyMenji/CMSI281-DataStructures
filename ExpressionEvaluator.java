import java.util.LinkedList;

public class ExpressionEvaluator {
	public static final String[] operators = { "+", "-", "x", "/", "%" };

	public static Boolean isOperator(String token) {
		for(String op : operators) {
			if(op.equals(token)) {
				return true;
			}
		}
		return false;
	}

	public static int operation(String op, int o1, int o2) {
		if(op.equals("+")) {
			return o1 + o2;
		}
		else if(op.equals("-")) {
			return o2 - o1;
		}
		else if(op.equals("x")) {
			return o1 * o2;
		}
		else if(op.equals("/")) {
			return o2 / o1;
		}
        else if(op.equals("%")) {
			return o2 % o1;
		} else {
			throw new IllegalArgumentException("You can only use the operators: +, -, x, /, %");
		}
	}

	public static int evaluate(String[] tokens) {
		LinkedList<Integer> expression = new LinkedList<Integer>();
		for(String token : tokens) {
			if (isOperator(token)) {
				expression.push(operation(token, expression.pop(), expression.pop()));
			}
			else {
				expression.push(Integer.parseInt(token));
			}
		}
		return expression.pop();
	}

	public static void main(String args[]) {
        System.out.print(evaluate(args));
	}
}