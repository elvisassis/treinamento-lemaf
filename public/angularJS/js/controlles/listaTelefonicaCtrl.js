//Declaração do controller listaTelefonicaCtrl
myApp.controller("listaTelefonicaCtrl", [ '$scope', 'contatos', 'operadoras',
		'serialGenerator','$rootScope','contatosAPI','$location','$route',
		function($scope, contatos, operadoras, serialGenerator, $rootScope, contatosAPI, $location,$route) {
			
			//Declaração do array de contatos

			$scope.contatos = contatos.data;

			//Metodo para apagar contato, utilizando o filter o metodo retorna somente os contatos não seleciodados e o atribui novamente ao array de contatos, assim somente será exibido os contatos não selecionados na tela após clicar no botao "Apagar Contato"
			$scope.apagarContatos = function(contatos) {
				$scope.contatos = contatos.filter(function(contato) {
					if (!contato.selecionado)
						return contato;
				});

			};
			

			$scope.editContato = function(contato){
				$rootScope.contato = contato;
				$rootScope.operadoras = operadoras.data;
				console.log($rootScope.contato);
				$rootScope.add = false;
				$rootScope.edit = true;
				$location.path("/editContato");
			}

			//Verifica se o contato está selecionado, caso esteja muda a cor de fundo do contato
			$scope.isContatoSelecionado = function(contatos) {
				return contatos.some(function(contato) {
					return contato.selecionado;
				});
			};
			$scope.ordernarPor = function(campo) {
				$scope.criterioDeOrdenacao = campo;
				$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
			};
			
			
			 
			$scope.showModal = function(contato)
		    {
		        $scope.show = true;
		        $scope.contato = contato;
		        
		    };

		    $scope.clicouBotaoSim = function()
		    {
		    	contatosAPI.delContato($scope.contato.id_contato).then(
					function(sucess){
					$scope.show = false;
					$route.reload();
				},
				function(error){
					console.log(error.status);
				});
		    	
		        
		    };

		    $scope.clicouBotaoNao = function()
		    {
		        $scope.show = false;
		    };

		}]);