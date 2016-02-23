/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;
import java.util.StringTokenizer;
       

/**
 *
 * @author Annie
 */
public class AnalizadorTexto extends Padre{ //herencia 
    public String cadena1;
    private String[]tokens1;    
    public String Palabra[];
    public int i=0,j=1,p=0,t=0;
    public int numPalabra[]= new int[30];
    private boolean ant = false,verify=false;

       
    public void RecibeCadena(String cadena){

    this.cadena1 = cadena;
    DivideTokens();

    }
    //HERENCIA: Sobreescribimos el metodo de la clase Padre
    @Override
    
    public void DivideTokens() {
    StringTokenizer tokens= new StringTokenizer(cadena1);
    t= tokens.countTokens();
    tokens1 = new String[t];
    Palabra = new String[30];
    numPalabra = new int[30];
    t=0;
    try{
    while(tokens.hasMoreElements()){
        String a = tokens.nextToken();

        tokens1[t] = a;
        System.out.println("VERIFICA:"+tokens1[t]);
        t++;

    }
    }catch (Exception e){

       System.out.println("ERROR AL GUARDAR TOKENS EN ARRAY "+e);

    }

    try {
        ComparaTokens();
    }catch (Exception e){
        System.out.println("ERROR AL COMPARAR TOKENS "+e);
    }

    }

    private void ComparaTokens(){

    //dos ciclos anidados para comparar si un elemento
        //de la cadena se repite
        //y el tercer ciclo para verificar que no se haya
        //comprobado anteriormente cierta palabra
     String aux;
     int a = t-1;
     for(i=0;i< a;i++){
         //ver que ya se haya encontrado esa palabra
         if(p > 0){
         for(int m=0;m<p;m++){

             if(tokens1[i].equals(Palabra[m])){
                 verify= true;
             }
         }

         }

         if(verify){

             //no hacer nada si ya se ha verificado
             //antes esa palabra
         }
         //en caso que no encontro la palabra verificamos
         //con los demas tokens[j]
         else{

             for(j=i+1;j< t;j++){
                 aux = tokens1[j];


                 if(tokens1[i].equals(aux)){

                     if(ant){// mas coincidencias
                         numPalabra[p]= numPalabra[p]+1;
                         //System.out.println("coincidencias"+" "+numPalabra[p]+" "+Palabra[p]);
                     }
                     else{//primera coincidencia
                         ant = true;
                         p++;
                         Palabra[p]=tokens1[i];
                         numPalabra[p]= 2;
                         //System.out.println("encontro  "+Palabra[p]);
                     }
                 }
             }//for j
             ant = false;
         }

         }//for i


    try {
        MuestraPalabras();
    }catch (Exception e){
       System.out.println("ERROR "+" IMPRIMIENDO PALABRAS"+e);
    }}

    private void MuestraPalabras(){

    for(int s=1; s<= p;s++){

     System.out.println("ENCONTRO    :"+""+Palabra[s]+numPalabra[s]+" veces");
    }
    //LimpiaVariables();
    }
      
    
    protected void LimpiaVariables(){
        p=0;
        t=0;
        i=0;
        j=1;
        verify = false;
        ant = false;


        for(int s=1; s<= p;s++){

            Palabra[s]= null;
            numPalabra[s]= 1;
        }

    }
    
    
    
}
