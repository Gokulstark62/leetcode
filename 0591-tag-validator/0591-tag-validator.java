class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < code.length()){
            if(code.charAt(i) == '<'){
                int j = i + 1;
                if(j < code.length() && valid(code.charAt(j))){
                    StringBuilder tag = new StringBuilder();
                    while(j < code.length() && code.charAt(j) != '>'){
                        if(!valid(code.charAt(j))){
                            return false;
                        }
                        tag.append(code.charAt(j));
                        j++;
                    }
                    if(j == code.length() || j - 1 == i || j - i - 2 > 9 || (i > 0 && stack.isEmpty())){
                        return false;
                    }
                    stack.push(tag.toString());
                    i = j + 1;
                }else if(j < code.length() && code.charAt(j) == '/'){
                    j++;
                    StringBuilder tag = new StringBuilder();
                    while(j < code.length() && code.charAt(j) != '>'){
                        if(!valid(code.charAt(j))){
                            return false;
                        }
                        tag.append(code.charAt(j));
                        j++;
                    }
                    String str = tag.toString();
                    if(j == code.length() || j - 1 == i || j - i - 2 > 9 || stack.isEmpty() ||
                     !stack.peek().equals(str)){
                        return false;
                    }
                    stack.pop();
                    i = j + 1;
                }else if(j < code.length() && code.charAt(j) == '!'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    int k = j + 8;
                    if(k >= code.length()){
                        return false;
                    }
                    String sub = code.substring(j, k);
                    if(!sub.equals("![CDATA[")){
                        return false;
                    }
                    int idx = code.indexOf("]]>", j);
                    if(idx == -1){
                        return false;
                    }
                    i = idx + 3;
                }else{
                    return false;
                }
            }else if(!stack.isEmpty()){
                i++;
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean valid(char c){
        return c >= 'A' && c <= 'Z';
    }
}