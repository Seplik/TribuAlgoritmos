import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {
	static Stack<String> stackSigns = new Stack<>();
    static Stack<String> stackNumbers = new Stack<>();

    public static void main(String args[]) {
        String op = "4*8 +6";
        separateOp(op);
        System.out.println(orderOp());
    }


    static public void separateOp (String op){
        Pattern patterns = Pattern.compile("[0-9]");
        Matcher matcher ;

        for (char c : op.toCharArray()) {
            matcher = patterns.matcher("" + c);
            if (matcher.matches()) {
                stackNumbers.push("" + c);
            } else {
            	stackSigns.push("" + c);
            }
        }

    }
    static public String orderOp (){
        StringBuilder res= new StringBuilder();
        int size = stackSigns.size();
        for (int i =0; i<stackSigns.size();i++){
            if (i==0 && (stackSigns.peek().equals("*") || stackSigns.peek().equals("/"))) {
                res.append(stackSigns.pop()); 
                res.append(stackNumbers.pop());
                res.append(stackNumbers.pop());
            }else if (stackSigns.peek().equals(" ")){
            	res.append(stackSigns.pop());
                if (stackSigns.peek().equals("*") || stackSigns.peek().equals("/")) {
                	res.append(stackSigns.pop());
                	res.append(stackNumbers.pop());
                	res.append(stackNumbers.pop());
                }else{
                	res.append(stackSigns.pop());
                	res.append(stackNumbers.pop());
                }

             }else if(stackSigns.peek().equals("*") || stackSigns.peek().equals("/")){
            	 res.append(stackSigns.pop());
            	 res.append(stackNumbers.pop());
            	 res.append(stackNumbers.pop());

            }else{
            	res.append(stackSigns.pop());
            	res.append(stackNumbers.pop());
            }
        }

        return res.toString();
    }

}
