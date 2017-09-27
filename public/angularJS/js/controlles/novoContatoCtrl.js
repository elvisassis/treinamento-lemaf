//Declaração do controller listaTelefonicaCtrl
		myApp.controller("novoContatoCtrl", [
		'$scope',
		'contatosAPI',
		'operadorasAPI',
		'serialGenerator',
		'$location',
		'operadoras',
		function($scope, contatosAPI, operadorasAPI, serialGenerator,
				$location, operadoras) {

			$scope.contatos = [];
			$scope.operadoras = operadoras.data;
			var carregarContatos = function() {
				contatosAPI.getContatos().then(function(success) {
					$scope.contatos = success.data;
				}, function(error) {
				});
			};

			$scope.adicionarContato = function(contato) {

				contato.serial = serialGenerator.generate();
				$scope.contatos.push(angular.copy(contato));
				contatosAPI.saveContato($scope.contatos).then(
						function(success) {
							delete $scope.contato; // delete para limpar a tela
							// apos a inclusao de um
							// contato
							$scope.contatoForm.$setPristine();
							$location.path("/contatos");
						});
			};

			carregarContatos();
		} ]);