
import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maickel
 */
public  class Principal extends JFrame { //Classe Principal
    //Declara��o de vari�veis globais:
     static String vetordes = "";
     static String vetorord1 = "";
     static String vetorord2 = "";
     static String vetorord3 = "";
     static JButton botao;
     //Fim das declara��es de vari�veis globais
     static JTextArea txt = new JTextArea(50, 80); //Cria um objeto do tipo TextArea
   
 public Principal() { //M�todo para criar o JPanel
     
     JScrollPane scrollingArea = new JScrollPane(txt);
     txt.setEditable(false);
     PrintStream printStream = new PrintStream(new JTextAreaOutputStream(txt));
     System.setOut(printStream);
     
     JPanel content = new JPanel( );
     content.setLayout(new BorderLayout());
     content.add(scrollingArea, BorderLayout.CENTER);
        
     //Caracteristicas da janela
     this.setContentPane(content);
     this.setTitle("Janela com as imagens fora de ordem e ordenadas");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.pack();
     }
 
public static void main(String[] args) { //M�todo principal da classe
     
      long time = 0; //V�riavel para o cronometro
       JOptionPane.showMessageDialog(null,"                   Bem vindo ao ordenador de imagens por tamanho em java !"
    + "\n� seguir  escolha a quantidade de imagens de sat�lites no arquivo � serem ordenadas, "
    + "\nvoc� poder� escolher entre 3 m�todos de ordena��o diferentes !"
    + "\nVamos L� !"); //Mensagem inicial de boas vindas ao programa
       
      String n=null; //Vari�vel que receber� o n�mero de imagens digitado
     while (n==null || n.equals("")){ 
     try{ //Parte do c�digo que poder� gerar erro caso o n�mero digitado seja nulo, zero ou for uma letra ou caracter
       n = (JOptionPane.showInputDialog("Quantas imagens ser�o ordenadas de acordo com o tamanho em Mb?"));
       int numero = Integer.parseInt(n);
      if(n==null| n.equals("0")){//Condi��o caso n�o seja digitado um n�mero ou caso seja 0
       JOptionPane.showMessageDialog(null,
                           "Voc� n�o respondeu a pergunta Corretamente.");//Erro caso condi��o acima
       break;
    }
    }
     catch(NumberFormatException e){ //Tratamento do erro se n�o for digitado um n�mero v�lido
       JOptionPane.showMessageDialog(null,
                           "Voc� n�o respondeu a pergunta Corretamente.");
       break;
    }
        
     int numero = Integer.parseInt(n);//Converte o numero digitado para uma string
     Random random = new Random () ; //intancia um objeto da classe random para sortear os n�meros
      int []vetor = new int[numero]; // Declara um vetor com tamanho definido pelo usu�rio
     for (int i=0; i<vetor.length; i++){ // La�o para gerar numeros aleat�rios
     vetor[i] = 250 + random.nextInt ( 200 ); // Gera numeros entre 250 e 450 que � o tamanho aproximado 
     //em Mb de uma imagem de sat�lite
    }
     
     for( int i=0; i<vetor.length; i++) {// La�o para coverter o vetor de n�meros em uma string
     for(i=0; i<vetor.length; i++) { // La�o para coverter o vetor de n�meros em uma string
      vetordes+=String.valueOf(vetor[i])+" | "; //Variavel  que recebe a string
    }
    }     
     
     JFrame win = new Principal(); //instancia um objeto da classe JFrame
     win.setVisible(true);//Torna o JFrame visivel
     StringWriter ss = new StringWriter();//Instancia um objeto da classe StringWriter para imprimir no textarea
     PrintWriter out = new PrintWriter (ss);//Instancia om objeto da classe PrintWriter para imprimir no textarea
       out.println("Tamanho de imagens aleat�rios\n\n [" + vetordes +"]\n\n");
      txt.setText (ss.toString());
      
     Object[] opcoes = { "BubbleSort", "SelectionSort", "InsertionSort", "Escolha um M�todo" };
     Object resposta;
     
     while (true) {
       resposta = JOptionPane.showInputDialog(null, "Escolha um m�todo para ordenar as imagens por tamanho", "M�todo Ordenador", JOptionPane.PLAIN_MESSAGE, null,opcoes,"Escolha um M�todo");
     if (resposta == null|| resposta.equals("Escolha um M�todo")){//Condi��o caso n�o seja escolhida uma op��o
       JOptionPane.showMessageDialog(null,"Voc� desistiu de ordenar!");//erro caso condi��o acima
     break;
    }
     
     else if (resposta =="BubbleSort"){//Algoritimo caso a op��o escolhida seja BubbleSort
     Chronometer.start(); //Inicia contagem de tempo pelo cronometro para ordenar os n�meros
      int aux = 0;
      int i = 0;
     for(i = 0; i<vetor.length; i++){
     for(int j = 0; j<vetor.length-1; j++){
     if(vetor[j] > vetor[j + 1]){
      aux = vetor[j];
      vetor[j] = vetor[j+1];
      vetor[j+1] = aux;
    }
    }
    }
      //Fim do algoritimo BubbleSort
      int [] vetororganizado = new int[vetor.length]; //Declara um vetor para receber os n�meros ordenados           
     for ( i=0; i < vetor.length; i++){ //la�o para que o vetor receba os n�meros ordenados
      vetororganizado[i]=vetor[i];//vetor recebendo os n�meros organizados pelo InsertionSort
    }
     for( i=0; i<vetor.length; i++) {//La�o para conveter o vetor organizado de n�meros para uma string
      vetorord1+=String.valueOf(vetororganizado[i])+" | "; //String que recebe o vetor organizado pelo BubbleSort
    }
       System.out.println ("Ordenadas pelo metodo BubbleSort por tamanho em ordem crescente :\n ["+vetorord1+"]\n");
     Chronometer.stop(); //Finaliza a contagem de tempo do cronometro 
      time = Chronometer.elapsedTime();  
      //Imprime no TextArea o tempo que demorou para ordenar os n�meros pelo m�todo:
       System.out.println("Tempo de Ordenacao: "+time +" milisegundos\n\n");
    }
     
     else if (resposta =="SelectionSort"){//Algoritimo caso a op��o escolhida seja SelectionSort
     Chronometer.start();//Inicia contagem de tempo pelo cronometro para ordenar os n�meros
     for (int i = 0; i < vetor.length - 1; i++){
      int aux = i;
     for (int j = i + 1; j < vetor.length; j++)
     if (vetor[j] < vetor[aux])
      aux = j;
      int MenorNumero = vetor[aux]; 
      vetor[aux] = vetor[i];
      vetor[i] = MenorNumero;
    }
      //Fim do algoritimo SelectionSort
      int [] vetororganizado = new int[vetor.length]; //Declara um vetor para receber os n�meros ordenados         
     for ( int i=0; i < vetor.length; i++){ //la�o para que o vetor receba os n�meros ordenados
      vetororganizado[i]=vetor[i];//vetor recebendo os n�meros organizados pelo InsertionSort
    }
     for( int i=0; i<vetor.length; i++) {//La�o para conveter o vetor organizado de n�meros para uma string
      vetorord2+=String.valueOf(vetororganizado[i])+" | ";//String que recebe o vetor organizado pelo SelectionSort
        }
     //Imprime o vetor organizado pelo m�todo SelectionSort dentro do TexArea
       System.out.println("Ordenadas pelo metodo SelectionSort por tamanho em ordem crescente:\n ["+vetorord2+"]\n");
     Chronometer.stop();  //Finaliza a contagem de tempo do cronometro 
      time = Chronometer.elapsedTime();  
      //Imprime no TextArea o tempo que demorou para ordenar os n�meros pelo m�todo:
       System.out.println("Tempo de Ordenacao: "+time +" milisegundos\n\n");
    }
  
     else if (resposta =="InsertionSort"){//Algoritimo caso a op��o escolhida seja InsertionSort
     Chronometer.start();//Inicia contagem de tempo pelo cronometro para ordenar os n�meros
     for (int i=1;i< vetor.length;i++) {
     for (int j=i;j>0;j--){
     if (vetor[j]< vetor[j-1]) {
      int temp = vetor[j];
      vetor[j] = vetor[j-1];
      vetor[j-1] = temp;
    }
    }
    }
     //Fim do algoritimo InsertionSort
      int [] vetororganizado = new int[vetor.length];//Declara um vetor para receber os n�meros ordenados
     for ( int i=0; i < vetor.length; i++){ //la�o para que o vetor receba os n�meros ordenados
      vetororganizado[i]=vetor[i];//vetor recebendo os n�meros organizados pelo InsertionSort
    }
     for( int i=0; i<vetor.length; i++) {//La�o para conveter o vetor organizado de n�meros para uma string
      vetorord3+=String.valueOf(vetororganizado[i])+" | "; //String que recebe o vetor organizado pelo InsertionSort
    }
     //Imprime o vetor organizado pelo m�todo InsertionSort dentro do TexArea
       System.out.println("Ordenadas pelo metodo InsertionSort por tamanho em ordem crescente:\n ["+vetorord3+"]\n");
     Chronometer.stop();//Finaliza a contagem de tempo do cronometro  
      time = Chronometer.elapsedTime();  
      //Imprime no TextArea o tempo que demorou para ordenar os n�meros pelo m�todo:
       System.out.println("Tempo de Ordenacao: "+time +" milisegundos\n\n");
    }
    }
    }
    }
    }

    

    
    
   