public  class Automata{

  //Autor: Rosario Hernández Luis Alberto.

  static void procesaCadena(String cadena){
    // q = δ*(q0,w)
    int q = delta_extendida(0,cadena);
    if(q==5){
      System.out.println("\n>>>>>>Cadena aceptada<<<<<<");
    }else{
      System.out.println("\n>>>>>>Cadena rechazada<<<<<<");
    }
  }

  /** Implementación de la función δ* */
  private static int delta_extendida(int estado_actual,String cadena){
    // Si ya no hay símbolos en la entrada
    // Caso base: δ*(q,λ) = q
    if(cadena=="") {
      System.out.println("S*("+estado_actual+",h)");
      return estado_actual;
    }

    // Si aún hay símbolos en la entrada
    // Se lee el siguiente símbolo
    char siguiente_simbolo = cadena.charAt(0);
    String resto_cadena = null;
    if(cadena.length()==1) //ya no hay más símbolos
      resto_cadena = "";
    else // el resto de la cadena es la sucadena a partir de la segunda posición
      resto_cadena = cadena.substring(1);
      
    // Caso recursivo:
    // δ*(q,σw) = δ*(δ(q,σ), w)
    System.out.println("S*(S("+estado_actual+","+siguiente_simbolo+"),"+(resto_cadena==""?"h":resto_cadena)+")");
    return delta_extendida(delta(estado_actual,siguiente_simbolo),resto_cadena);
  }

  /** Implementación de la función δ (transiciones entre estados)
   * @param estado actual
   * @param simbolo leido
   * @return el estado siguiente */
  private static int delta(int estado,char simbolo){
    if(estado==0){
      if(simbolo=='1' || simbolo=='2')
        return 1;
      if(simbolo=='x' || simbolo=='=')
        return 6;
    }
    if(estado==1){
      if(simbolo=='1' || simbolo=='2')
        return 1;
      if(simbolo=='x')
        return 2;
      if(simbolo=='=')
        return 6;
    }
    if(estado==2){
      if(simbolo=='1' || simbolo=='2')
        return 3;
      if(simbolo=='x' || simbolo=='=')
        return 6;
    }
    if(estado==3){
      if(simbolo=='1' || simbolo=='2')
        return 3;
      if(simbolo=='x')
        return 2;
      if(simbolo=='=')
        return 4;
    }
    if(estado==4){
      if(simbolo=='1' || simbolo=='2')
        return 5;
      if(simbolo=='x' || simbolo=='=')
        return 6;
    }
    if(estado==5){
      if(simbolo=='1' || simbolo=='2')
        return 5;
      if(simbolo=='x' || simbolo=='=')
        return 6;
    }
    if(estado==6)
      return 6;
    return -1;
    }
    
  public static void main(String[] args){
    System.out.println("\nS=Delta minuscula, h=Lambda minuscula\n");
    if(args.length>=1){
      Automata.procesaCadena(args[0]);
    }else{
      System.out.println("Uso: java Automata <cadena de entrada>");
    }
  }
}