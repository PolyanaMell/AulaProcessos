package view;


import javax.swing.JOptionPane;//adaptado
import controller.ProcessosController; //importa a classe

public class Principal {

	public static void main(String[] args) {
		ProcessosController procController = new ProcessosController(); //cria o método construtor	
		String param = JOptionPane.showInputDialog(null,"Digite um PID ou nome do processo a ser finalizado.exe:");	//Adaptado: Informar um PID ou nome	
		
		/*PRIMEIRO MÉTODO, mostrar versão, arquitetura e o SO*/
	   //String os = procController.os(); //instancia
       //System.out.println(os);//imprime os valores
  
		
//---------------------------------------------------------------------------		
		
       /*SEGUNDO MÉTODO, inicializar processos*/
        
      //String process = "c:\\Windows\\notepad.exe"; //Iniciando qualquer app executável
      //procController.callProcess(process);
		
//---------------------------------------------------------------------------		
		/*TERCEIRO MÉTODO, mostrando todos os processos */
		
		//String process = "TASKLIST /FO TABLE"; //Mostrando todos os processos como no CMD
		//String process = "PING -t20 www.google.com.br"; //Ping
		//String process = "TRACERT www.google.com.br"; //para descobrir o caminho que os pacotes fazem até chegar no site
		//String process = "ipconfig";		
		//procController.readProcess(process);
		
//---------------------------------------------------------------------------
/*QUARTO MÉTODO, MATANDO PROCESSOS - original do professor*/
		
		//String param = "notepad.exe"; //Aqui vc coloca o nome ou o PID e ele mata o processo
		//procController.killProcess(param);
		
//////		
		
		/*QUARTO MÉTODO, ADAPTADO COM JOPTION.PANE para informar o nome ou PID do processo a ser finalizado*/
		//O usuario informará um PID para que o processo seja finalizado
		procController.killProcess(param);
		System.out.println("FINISH HIM!");
		
	}
	

}
//PID = código do cmd
//Ping ou taxa de latência é o tempo que leva para um pacote de dados ser transmitido de seu 
//dispositivo para um servidor na Internet e retornar ao dispositivo, sendo medido em milissegundos (ms)