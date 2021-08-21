package controller;

//importa 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {

	public ProcessosController() {
		super();
	}
	
	//Fazer uma opera��o de retorno, para mostrar o SO que est� em execu��o nessa m�quina
	
	public String os() {
		String os = System.getProperty("os.name"); //Traz o nome do sistema operacional
		String arch = System.getProperty("os.arch"); //Traz a arquitetura do sistema operacional
		String version = System.getProperty("os.version");//Traz a vers�o do sistema operacional
		return os + " - v. "+version +" - "+ "arch. "+arch; //retorna os valores
	}
	
//----------------------------------------------------------------------------------------------------------
	
	//Para fazer um processo incializar outro processo
    public void callProcess(String process) { 
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String msgErro = e.getMessage(); //Mostrando apenas a primeira linha do erro
			//System.err.println(msgErro); //Mostra a mensagem com cor vermelha de erro
			
			if (msgErro.contains("740")) { // Vai executar esse bloco, caso o erro tenha o 740 (erro pelo processo precisar de permiss�o do administrador para executar)
				//cmd /c caminho_do_processo //Vai chamar a tela para o administrador permitir ou n�o a execu��o do programa
	           StringBuffer buffer = new StringBuffer();
	           buffer.append("cmd /c"); //Criando a forma para executar como administrador
	           buffer.append(" "); //Criando a forma para executar como administrador
	           buffer.append(process); //Criando a forma para executar como administrador
	           try {
				Runtime.getRuntime().exec(buffer.toString()); //Tenta executar
			} catch (IOException e1) {
				e1.printStackTrace(); //Caso n�o execute vai dar um erro
			}
			}else {
				e.printStackTrace(); //Mostrando o erro caso n�o contenha erro = 740
			}
		}
		
	}
    
    //---------------------------------------------------------------------------------------
	
    
    //Fazer com que um processo leia outro processo
    
    public void readProcess(String process) {
        //ler a sa�da de um outro processo e printar
    	
    	//Vai executar um processo, por�m, precisa estar dentro de um try catch
    	try {
			Process p = Runtime.getRuntime().exec(process); //retorna um processo (vari�vel do tipo processo), enquanto ele estiver em execu��o, a vari�vel p continua recebendo dados
		    InputStream fluxo = p.getInputStream(); //basicamente um fluxo de bits
		    InputStreamReader leitor = new InputStreamReader(fluxo); //Vai ler e converter para String
		    BufferedReader buffer = new BufferedReader(leitor); //Est� guardando a vari�vel no buffer
		    String linha = buffer.readLine(); //Lendo a primeira linha do Buffer, se eu usar o comando novamente, ele vai pegar a pr�xima linha
		    while (linha != null) { //Fazendo at� que o Buffer estoure
		    	System.out.println(linha);
		    	linha = buffer.readLine();
    	     }
		    buffer.close();
		    leitor.close();
		    fluxo.close();
    	} catch (IOException e) {
			e.printStackTrace(); //Printa todo o erro
		} 
    	}
    
    //--------------------------------------------------------------
    
    
    //Matando processos, pode ser pelo nome ou pelo PID
    public void killProcess(String param) {
    	//SO Windows, comando para matar:
    	String cmdPid = "TASKKILL /PID";// matar por PID
    	String cmdNome = "TASKKILL /IM"; //matar por nome
    	int pid = 0;//
    	StringBuffer buffer = new StringBuffer();
    	//PID � exclusivamente num�rico, nome pode ter n�mero mas � raro
    	
    	
    	//NumberFormatException -> Exception
    	try {
    	//TAASKKILL /PID <VALOR DE PID>	
    	pid = Integer.parseInt(param); //Se for apenas n�mero, vai matar PID
    	buffer.append(cmdPid);
    	buffer.append(" ");
    	buffer.append(pid);
    	}
    	catch (Exception e) {
    		//TASKKILL /IM nomedoprocesso.exe
    		buffer.append(cmdNome);
    		buffer.append(" ");
    		buffer.append(param);
    		
    	}
    	
    	callProcess(buffer.toString());
    	
    }
    
    }    

//crtl + shift + o = corrige imports
//crtl + d = deleta a linha
//regedit = acesso como administrador
//buffer = variavel de mem�ria