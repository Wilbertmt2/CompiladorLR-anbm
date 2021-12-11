import java.util.Stack;


public class andifbm {
    Stack pila;
    public andifbm(){
        pila =new Stack();
        
    }
    int mayor=0;
    
    public void i(String cadena){
        mayor=0;
        pila.clear();
        pila.push("#");
        p(cadena);
        if (mayor==0){
            pila.clear();
            pila.push("#");
            p2(cadena);
        }
        resultado();
        
    }
    //checar si numero de a's mayor que b's
    public void p(String cadena){
        Stack respaldo=(Stack)pila.clone();
        Stack respaldo2pos=(Stack)pila.clone();
        respaldo.pop();
        respaldo2pos.pop();
        //System.out.println("Pila"+pila);
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
            //System.out.println(cadena);
            p(cadena.substring(1,cadena.length()));
        }else if(!pila.empty()&&!cadena.isEmpty()&&cadena.charAt(0)=='b'){//Se encuetra una b en la cadena, por lo que se agrega y empieza la verificacion
            if(pila.peek()=="a"){
                pila.pop();
                pila.push("A");
            }
            pila.push("b");
            //System.out.println(cadena);
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
    public void p2(String cadena){
        Stack respaldo=(Stack)pila.clone();
        Stack respaldo2pos=(Stack)pila.clone();
        respaldo.pop();
        respaldo2pos.pop();
        //System.out.println("Pila"+pila);
        if(!respaldo2pos.empty()){
            respaldo2pos.pop();
        }
        if (!pila.empty()&&pila.peek()=="b"&& !respaldo.empty() &&respaldo.peek()=="B" && !respaldo2pos.empty() && respaldo2pos.peek()=="a"){//Esto ocurre cuando ya se encuentra una b, y se intenta verificar que a sea mayor que b
            
                pila.pop();
                pila.pop();
                pila.pop();
                pila.push("B");
                p2(cadena);
            

        }else if(!pila.empty()&&pila.peek()=="b"&&!cadena.isEmpty()){
            if(!pila.empty()&&pila.peek()=="b"&& !respaldo.empty() &&respaldo.peek()=="B"){
                pila.pop();
                pila.pop();
                pila.push("B");
                p2(cadena);
            }
        }else if(cadena.length()==0&&pila.peek()=="B"){
            pila.pop();
            pila.push("S");
            p2(cadena);
        }else if(cadena.length()==0&&!pila.empty()&&pila.peek()=="b"&&!respaldo.empty() &&respaldo.peek()=="B"){
            pila.pop();
            pila.pop();
            pila.push("B");
            p2(cadena);
        }else if(!pila.empty()&&!cadena.isEmpty()&&cadena.charAt(0)=='a'){
            pila.push("a");
            //System.out.println(cadena);
            p2(cadena.substring(1,cadena.length()));
        }else if(!pila.empty()&&!cadena.isEmpty()&&cadena.charAt(0)=='b'){//Se encuetra una b en la cadena, por lo que se agrega y empieza la verificacion
            if(pila.peek()!="B"){
                pila.push("b");
                //System.out.println(pila);
                pila.pop();
                pila.push("B");
            }else{
                pila.push("b");
            }
            
            //System.out.println(pila);
            //System.out.println(cadena);
            p2(cadena.substring(1,cadena.length()));
        }else if(!pila.empty()&&cadena.length()==0&&pila.peek()=="b"){
            pila.pop();
            pila.push("B");
            p2(cadena);
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
            //System.out.println("Cadena valida");
            mayor=1;
            
        }else{
            //System.out.println("Cadena no valida");
            
        }
    }
    public void resultado(){
        
        if(mayor==1){
            System.out.println("Cadena valida");
        }else{
            System.out.println("Cadena no valida");
        }
    }
    public static void main(String[] args) {
        andifbm objeto = new andifbm();
        objeto.i("ab");//1
        objeto.i("aabbb");//2
        objeto.i("aaabb");//3
        objeto.i("aaaaa");//4
        objeto.i("bbbbb");//5
        objeto.i("aaacbb");//6
        objeto.i("aaabbb");//7
        objeto.i("abba");//8
        objeto.i("bbbaaa");//9
        objeto.i("aabbbbb");//10
    }
}