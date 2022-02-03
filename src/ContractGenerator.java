import java.util.HashMap;
import java.util.Map;

public class ContractGenerator {

    public static String contractGenerator(String text, Map<String, String> map){
        
        StringBuilder sb = new StringBuilder();

        // we are using two nested for loops here
        // outer for loop or index i will look for '{{' in the input
        // inner for loop or index j will loop for '}}' in the input
        // when appropriate, we look for the string inside {{ }} in the map and append the value to the StringBuilder
        // all characters outside {{ }} are appended as it is in the StringBuilder
        // if map doesn't contain the inside String in {{ }}, then we don't append anything to the StringBuilder and move on

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '}') throw new IllegalArgumentException("invalid input"); // handling cases like "abc}}"
            if(text.charAt(i) == '{') {
                if(i == text.length() - 1) throw new IllegalArgumentException("invalid input"); // handling cases like "{"
                if(text.charAt(i + 1) != '{') throw new IllegalArgumentException("invalid input"); // handling cases like "{abc}}"
                else{
                    if(i == text.length() - 2) throw new IllegalArgumentException("invalid input"); // handling cases like "{{"
                    int j = i + 1;
                    for(; j < text.length(); j++){
                        if(text.charAt(j) == '}'){
                            if(j == text.length() - 1) throw new IllegalArgumentException("invalid input"); // handling cases like "{{abc}"
                            if(text.charAt(j + 1) != '}') throw new IllegalArgumentException("invalid input"); // handling cases like "{{abc}a"
                            else {
                                if(map.containsKey(text.substring(i + 2, j))){
                                    sb.append(map.get(text.substring(i + 2, j)));
                                }
                                i = j + 2;
                                break;
                            }
                        }
                    }
                    if(i < j) throw new IllegalArgumentException("invalid input"); // handling cases like "{{abc"
                }
            }
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        
        Map<String, String> map = new HashMap<>();

        map.put("Company Nam", "Evisort");
        map.put("Company products", "products and service");

        System.out.println(contractGenerator("{{Company Name}} is committed to", map));
        
    }
    
    
    
}
