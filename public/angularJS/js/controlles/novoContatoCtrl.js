//Declaração do controller listaTelefonicaCtrl
		myApp.controller("novoContatoCtrl", [
		'$scope',
		'contatosAPI',
		'operadorasAPI',
		'serialGenerator',
		'$location',
		'operadoras',
		'$rootScope',
		function($scope, contatosAPI, operadorasAPI, serialGenerator,
				$location, operadoras, $rootScope) {

			$scope.operadoras = operadoras.data;
			$scope.adicionarContato = function(contato) {
				/*contato.serial = serialGenerator.generate();
				contatosAPI.saveContato(contato).then(
						function(success) {
							
							// apos a inclusao de um
							// contato
							console.log(success);
							$scope.contatoForm.$setPristine();
							$location.path("/contatos");
						});*/
				console.log(contato);
			};
		} ]);