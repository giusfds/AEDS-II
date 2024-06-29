
class RecEquation{
    private boolean a;
    private boolean b;
    private boolean c;
    private String eq;

    RecEquation(String str){
        this.a = str.charAt(2) == '0' ? false : true;
        this.b = str.charAt(4) == '0' ? false : true;
        
        if(str.charAt(0) == '3'){
            this.c = str.charAt(6) == '0' ? false : true;

            if(str.charAt(str.length() - 1) == ' '){
                this.eq = Q14.substring(str, 8, str.length() - 1);
            }else{
                this.eq = Q14.substring(str, 8, str.length());
            }
        }else{
            if(str.charAt(str.length() - 1) == ' '){
                this.eq = Q14.substring(str, 6, str.length() - 1);
            }else{
                this.eq = Q14.substring(str, 6, str.length());
            }            
        }

    }

    private boolean and(boolean[] bool, int length, int i){
        if(i < length){
            if(bool[i] == false)
                return false;
            else 
                return and(bool, length, i + 1);
        }else{
            return true;
        }
    }
    private boolean or(boolean[] bool, int length, int i){
        if(i < length){
            if(bool[i] == true)
                return true;
            else
                return or(bool, length, i + 1);
        }else{
            return false;
        }
    }
    private String getUpdatedString(int i){
        String newEq = new String();

        if(i < this.eq.length()){
            if(this.eq.charAt(i) == 'A')
                newEq = (this.a ? '1' : '0') + getUpdatedString(i + 1);
            else if(this.eq.charAt(i) == 'B')
                newEq = (this.b ? '1' : '0') + getUpdatedString(i + 1);
            else if(this.eq.charAt(i) == 'C')
                newEq = (this.c ? '1' : '0') + getUpdatedString(i + 1);
            else
                newEq = this.eq.charAt(i) + getUpdatedString(i + 1);
        }

        return newEq;
    }

    private void updateValues(){
        this.eq = getUpdatedString(0);
    }

    private boolean isSimple(int start){
        if(start < this.eq.length()){
            if(this.eq.charAt(start) == '('){
                return false;
            }else if(this.eq.charAt(start) == ')'){
                return true;
            }else{
                return isSimple(start + 1);
            }
        }

        return true;
    }

    private boolean[] getValues(int i, int arrayIndex){
        boolean[] bool = new boolean[10];
        
        if(i < this.eq.length() && this.eq.charAt(i) != ')'){
            if(this.eq.charAt(i) == '1'){
                bool = getValues(i + 1, arrayIndex + 1);
                bool[arrayIndex] = true;
            }else if(this.eq.charAt(i) == '0'){
                bool = getValues(i + 1, arrayIndex + 1);
                bool[arrayIndex] = false;
            }else{
                bool = getValues(i + 1, arrayIndex);
            }
        }

        return bool;
    }


    private int getLength(int i){
        int length = 0;

        if(i < this.eq.length() && this.eq.charAt(i) != ')'){
            if(this.eq.charAt(i) == '1' || this.eq.charAt(i) == '0'){
                length = 1 + getLength(i + 1);                
            }else{
                length = getLength(i + 1);
            }
        }

        return length;
    }

    private int findClosingBracket(int i){
        return this.eq.charAt(i) == ')' ? i : findClosingBracket(i + 1);
    }

    private String solveEquation(int i){
        if(this.eq.length() > 1){
            if(this.eq.length() > 1 && i >= this.eq.length() - 1){
                this.eq = this.solveEquation(0);
            }
            
            else if(this.eq.charAt(i) == 'a' && this.eq.charAt(i + 1) == 'n' && this.eq.charAt(i + 2) == 'd' && this.eq.charAt(i + 3) == '('){
                if(isSimple(i + 4)){
                    int j = i + 4;
                    int arrayLength = 0;
                    char resp = '0';
                    boolean[] values = new boolean[10];

                    values = this.getValues(j, 0);
                    arrayLength = this.getLength(j);
                    
                    resp = and(values, arrayLength, 0) ? '1' : '0';

                    j = this.findClosingBracket(j);
                    
                    this.eq = Q14.substring(this.eq, 0, i) + resp + Q14.substring(this.eq, j + 1, this.eq.length());

                    this.eq = this.solveEquation(i);
                }
            }
            
            else if(this.eq.charAt(i) == 'o' && this.eq.charAt(i + 1) == 'r' && this.eq.charAt(i + 2) == '('){
                if(isSimple(i + 3)){
                    int j = i + 3;
                    int arrayLength = 0;
                    char resp = '0';
                    boolean[] values = new boolean[10];

                    values = this.getValues(j, 0);
                    arrayLength = this.getLength(j);
                    
                    resp = or(values, arrayLength, 0) ? '1' : '0';

                    j = this.findClosingBracket(j);
                    
                    this.eq = Q14.substring(this.eq, 0, i) + resp + Q14.substring(this.eq, j + 1, this.eq.length());

                    this.eq = this.solveEquation(i);
                }
            }

            else if(this.eq.charAt(i) == 'n' && this.eq.charAt(i + 1) == 'o' && this.eq.charAt(i + 2) == 't' && this.eq.charAt(i + 3) == '('){
                if(isSimple(i + 4)){
                    char resp = '0';
                    int j = i + 4;

                    if(this.eq.charAt(j) == '1')
                        resp = '0';
                    else if(this.eq.charAt(j) == '0')
                        resp = '1';

                    j = this.findClosingBracket(j);

                    this.eq = Q14.substring(this.eq, 0, i) + resp + Q14.substring(this.eq, j + 1, this.eq.length());

                    this.eq = this.solveEquation(i);
                }
            }

            this.eq = this.solveEquation(i + 1);
        }

        return this.eq;
    }

    public String solveEquation(){
        this.updateValues();
        this.solveEquation(0);
        return this.eq;
    }
}

public class Q14{

    public static String substring(String str, int start, int end){
        String newStr = new String();
        
        if(start < end){
            newStr = str.charAt(start) + substring(str, start + 1, end);
        }

        return newStr;
    }
    
    public static void main(String[] args){
        String str = new String();

        do{
            str = MyIO.readLine();
            
            if(str.charAt(0) != '0'){
                RecEquation eq = new RecEquation(str);

                MyIO.println(eq.solveEquation());
            }
        }while(str.charAt(0) != '0');
    }
}