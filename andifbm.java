import java.util.Stack;
public class andifbm {
    Stack pila;
    public andifbm(){
        pila =new Stack();
        
    }
    public void i(String cadena){
        pila.push("#");
        p(cadena);
    }
    public void p(String cadena){
        Stack respaldo=(Stack)pila.clone();
        Stack respaldo2pos=(Stack)pila.clone();
        respaldo.pop();
        respaldo2pos.pop();
        System.out.println("Pila"+pila);
        if(!respaldo2pos.empty()){
            respaldo2pos.pop();
        }
        if (!pila.empty()&&pila.peek()=="b"&& !respaldo.empty() &&respaldo.peek()=="A" && !respaldo2pos.empty() && respaldo2pos.peek()=="a"){//Esto ocurre cuando ya se encuentra una b, y se intenta verificar que a sea mayor que b
            
                pila.pop();
                pila.pop();
                pila.pop();
                pila.push("A");
                p(cadena);
            

        }else if(!pila.empty()&&pila.peek()=="A"&&cadena.isEmpty()){//&&cadena.charAt(0)!='b'){
            if(!pila.empty()&&pila.peek()=="A"&& !respaldo.empty() &&respaldo.peek()=="a"){
                pila.pop();
                pila.pop();
                pila.push("A");
                p(cadena);
            }else if(!pila.empty()&&pila.peek()=="A"){
                pila.pop();
                
                pila.push("S");
                p(cadena);
            }
        }else if(!pila.empty()&&!cadena.isEmpty()&&cadena.charAt(0)=='a'){
            pila.push("a");
            System.out.println(cadena);
            p(cadena.substring(1,cadena.length()));
        }else if(!pila.empty()&&!cadena.isEmpty()&&cadena.charAt(0)=='b'){//Se encuetra una b en la cadena, por lo que se agrega y empieza la verificacion
            if(pila.peek()=="a"){
                pila.pop();
                pila.push("A");
            }
            pila.push("b");
            System.out.println(cadena);
            p(cadena.substring(1,cadena.length()));
        }else if(!pila.empty()&&cadena.length()==0&&pila.peek()=="a"){
            pila.pop();
            pila.push("A");
            p(cadena);
        }else
        if (cadena.length()==0&&!pila.empty()&&pila.peek()=="S"){
            pila.pop();
            q();
        }else{
            q();
        }
    }
    public void q(){
        if(!pila.empty()&&pila.peek()=="#"){
            pila.pop();
            System.out.println("Cadena valida");
        }else{
            System.out.println("Cadena no valida");
        }
    }
    public static void main(String[] args) {
        andifbm objeto = new andifbm();
        objeto.i("aab");
        
    }
}