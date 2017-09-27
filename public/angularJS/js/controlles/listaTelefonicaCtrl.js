//Declaração do controller listaTelefonicaCtrl
		myApp.controller("listaTelefonicaCtrl",['$scope','contatos','operadoras','serialGenerator',function($scope,contatos,operadoras,serialGenerator){
			$scope.app = "Lista Telefonica" //Definição de uma variavel para o nome da aplicação
			//Declaração do array de contatos
				
			$scope.contatos = contatos.data;

			//Declaração do array de operadoras
			$scope.operadoras = operadoras.data;
				
		
			//Metodo para apagar contato, utilizando o filter o metodo retorna somente os contatos não seleciodados e o atribui novamente ao array de contatos, assim somente será exibido os contatos não selecionados na tela após clicar no botao "Apagar Contato"
			$scope.apagarContatos = function(contatos){
				$scope.contatos = contatos.filter(function(contato){
					if (!contato.selecionado) return contato;
				});
				
			};
			
			var generateSerial = function(contatos){
				contatos.forEach(function (item){
					item.serial = serialGenerator.generate();
				});
			};

			//Verifica se o contato está selecionado, caso esteja muda a cor de fundo do contato
			$scope.isContatoSelecionado = function(contatos){
				return contatos.some(function(contato){
					return contato.selecionado;
				});
			};
			$scope.ordernarPor = function(campo){
				$scope.criterioDeOrdenacao = campo;
				$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
			};
			generateSerial($scope.contatos);
			
		}]);