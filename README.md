## Objetivo

Parabéns, você passou para a segunda fase do processo seletivo da [MáximaTech](https://maximatech.com.br/) para desenvolvedor Android.

## Instruções

1. Criar um fork deste repositório, transformar ele em privado, adicionar o nosso usuário (talentosmaxima) como colaborador e implementar o aplicativo conforme instruções abaixo.
2. Arquivos de design e mockups estão contidos nos itens 3.0 a 3.2.
3. Enviar um e-mail para <talentoshumanos@maximatech.com.br> com:
	* Assunto "[Teste Desenvolvedor Android] - Nome do candidato"
	* Link: -> Repositório privado no Github.

## 1.0 - O que esperamos?  ;-)

* Um aplicativo Android que faça:

1. Splash
2. Menu principal    
	* No menu principal ao tocar na opção Clientes direcionar para a tela Dados do cliente
3. Dados do cliente	
	* O botão Verificar status do cliente tem que exibir numa Toast ou snackbar  o status do cliente com a data e hora (tela 3.1)
	* O BottomNavigationView deve permitir alternar entre as telas de Histórico de pedidos, Alvarás ou Dados do Cliente
	
    * Histórico de pedidos
	    * O menu deve abrir a opção de legendas (tela 3.3)
	    * A pesquisa deve abrir o campo de pesquisa textual	    	    
		
    * Alvarás
	    * A seta da toolbar deve voltar voltar para a tela anterior	    

	
O aplicativo deverá:
* Reproduzir a interface definida no layout fornecido
* Consumir o json (clientes.json) por meio de uma requisição http para exibir os dados dos clientes
* Consumir o json (pedidos.json) por meio de uma requisição http  para listagem de histórico de pedidos
* Salvar os dados em um banco de dados e usar para exibir mesmo offline.


Itens Opcionais:
* A seta da toolbar deve voltar para o menu principal
* Snackbar de status

3. Dados do cliente	
    * Histórico de pedidos
	    * A seta da toolbar deve voltar para a tela anterior
    * Menu legendas
	    * O menu Legendas deve abrir o Dialog com as legendas (tela 3.4)	
    * Dialog Legendas
	    * Botão Fechar deve fechar o Dialog	

* Testes unitários e de interfaces

	
		
4. Criação de Serviços em Background (Sugestões: WorkManager, JobScheduler, AlarmManager)
* Desenvolver um serviço em background que cria uma notificação que avisa o usuário a cada 15 minutos para entrar no aplicativo. Ao clicar na notificação o aplicativo deverá ser aberto. 


## 2.0 - Requisições  REST (Sugestões: Retrofit, HttpURLConnection )

A tela abaixo possui o botão **Verificar status do cliente** que é responsável por enviar uma requisição **GET** para o endpoint informado no item 4.0, para retornar o status do cliente. 

![Tela Service](https://github.com/talentosmaxima/Android/blob/master/Design/Screenshots/3.1%20-%20Cadastro%20do%20cliente%20%E2%80%93%20Snackbar%20de%20status.png)

Quando o usuário clicar no botão em questão deve-se consultar o status que está armazenado no arquivo json e retornar o texto **Data/Hora - Status cliente**, por exemplo, **10/09/2018 - Status ativo** 


## 3.0 - Persistencia de Dados (Sugestão: SQLite, realmDB)

A persistencia de dados tem como objetivo permitir que os dados estejam disponíveis de maneira OFFLINE, bastando que uma primeira conexão seja realizada.

O app deve possuir um CRUD para os dados de Cliente, Contatos e Histórico de pedidos. 
(Dica: Seria interessante estabelecer um relacionamento entre Cliente e Contatos.)
 
Importante salientar que **tudo que você enviar será avaliado e valorizamos muito a implementação dos itens opcionais**.

### 4.0 - Onde estão as coisas? 

### 4.1 - Design 

Todo material pertinente para reproduzir as telas está na pasta *./Design*, recomendamos dar uma olhada no arquivo *./Design/Protótipo maxApp.xd* para verificar dimensões, bordas, cores, estilos e tamanhos corretos.

<sub>*o Adobe XD é um app pago, mas tem versão free https://www.adobe.com/br/products/xd.html <sub>
	
### 4.2 - Arquivos de Design 

[Arquivos Design](https://github.com/talentosmaxima/Android/blob/master/Design/Prot%C3%B3tipo-maxApp.pdf)

### 5.0 - JSON 

Os JSONs utilizados nessa avaliação estão hospedados e você pode ver mais informações pelo link [https://maximatech.docs.apiary.io](https://maximatech.docs.apiary.io).

## 6.0 - O que vamos avaliar?

* Organização do projeto
* Utilização de padrões arquiteturais
* Clareza do código
* Escolha de estruturas e bibliotecas
* Ausência de crashs e bugs
* Detalhes de UI
* Linguagem de programação

## Dúvidas

Entre em contato com <talentoshumanos@maximatech.com.br>
