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
    * Rodapé: Ícone Núvem para indicar conexão com a internet, Ícone Núvem cortada para indicar que não tem conexão com a internet
	* No menu principal ao tocar na opção Clientes direcionar para a tela Dados do cliente
3. Dados do cliente
	* A seta da toolbar deve voltar para o menu principal
	* O botão Verificar status do cliente tem que exibir numa snackbar o status do cliente com a data e hora (tela 3.1)
	* O bottom navigation deve levar às telas de Histórico de pedidos, Alvarás ou Dados do Cliente
    * Snackbar de status
    * Histórico de pedidos
	    * O menu deve abrir a opção de legendas (tela 3.3)
	    * A pesquisa deve abrir o campo de pesquisa textual
	    * A seta da toolbar deve voltar para a tela anterior
	    * O bottom navigation deve levar às telas de Histórico de pedidos, Alvarás ou Dados do Cliente
    * Menu legendas
	    * O menu Legendas deve abrir o Dialog com as legendas (tela 3.4)
    * Dialog Legendas
	    * Botão Fechar deve fechar o Dialog
    * Alvarás
	    * A seta da toolbar deve voltar voltar para a tela anterior
	    * O bottom navigation deve levar às telas de Histórico de pedidos, Alvarás ou Dados do Cliente
4. Criação de Serviços em Background
	* Desenvolver um serviço em background que cria uma notificação que avisa o usuário a cada 5 minutos para entrar no aplicativo. Ao clicar na notificação o aplicativo deverá ser aberto. 
	
O aplicativo deverá:

* Reproduzir a interface definida no layout fornecido
* Consumir o json (clientes.json) por meio de uma requisição http para exibir os dados dos clientes
* Consumir o json (pedidos.json) por meio de uma requisição http  para listagem de histórico de pedidos
* Rodar um serviço em background que cria uma notificação para alertar o usuário para entrar no aplicativo. 


Sugestões:
* Salvar os dados num banco de dados e recuperá-los em caso de falha de conexão
* Testes unitários e de interfaces

## 2.0 - Requisições  REST 

A tela abaixo possui o botão **Verificar status do cliente** que é responsável por enviar uma requisição **GET** para o endpoint informado no item 4.0, para retornar o status do cliente. 

![Tela Service](https://github.com/talentosmaxima/Android/blob/master/Design/Screenshots/3.1%20-%20Cadastro%20do%20cliente%20%E2%80%93%20Snackbar%20de%20status.png)

Quando o usuário clicar no botão em questão deve-se consultar o status que está armazenado no arquivo json e retornar o texto **Data/Hora - Status cliente**, por exemplo, **10/09/2018 - Status ativo** 

Importante salientar que **tudo que você enviar será avaliado**

### 3.0 - Onde estão as coisas? 

### 3.1 - Design 

Todo material pertinente para reproduzir as telas está na pasta *./Design*, recomendamos dar uma olhada no arquivo *./Design/Protótipo maxApp.xd* para verificar dimensões, bordas, cores, estilos e tamanhos corretos.

<sub>*o Adobe XD é um app pago, mas tem versão free https://www.adobe.com/br/products/xd.html <sub>
	
### 3.2 - Arquivos de Design 

[Arquivos Design](https://github.com/talentosmaxima/Android/blob/master/Design/Prot%C3%B3tipo-maxApp.pdf)

### 4.0 - JSON 

Os JSONs utilizados nessa avaliação estão hospedados e você pode ver mais informações pelo link [https://maximatech.docs.apiary.io](https://maximatech.docs.apiary.io).

## 5.0 - O que vamos avaliar?

* Organização do projeto
* Utilização de padrões arquiteturais
* Clareza do código
* Escolha de estruturas e bibliotecas
* Ausência de crashs e bugs
* Detalhes de UI
* Linguagem de programação

## Dúvidas

Entre em contato com <talentoshumanos@maximatech.com.br>
