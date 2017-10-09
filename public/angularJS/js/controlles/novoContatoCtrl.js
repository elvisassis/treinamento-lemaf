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
				contato.serial = serialGenerator.generate();
				contatosAPI.saveContato(contato).then(
						function(success) {
							
							// apos a inclusao de um
							// contato
							$scope.contatoForm.$setPristine();
							$location.path("/contatos");
						});
<<<<<<< HEAD
=======
				console.log(contato);
>>>>>>> 20604a603d0be2f7423ead8c09279ac2c7f0b5cb
			};
		} ]);