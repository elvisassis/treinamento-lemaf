myApp.controller("editContatoCtrl", [
		'$scope',
		'serialGenerator',
		'$location',
		'operadoras',
		'contato',
		'contatosAPI',
		function($scope, serialGenerator,
				$location, operadoras, contato, contatosAPI) {

			$scope.operadoras = operadoras.data;
			$scope.adicionarContato = function(contato) {
				//contato.serial = serialGenerator.generate();
				contatosAPI.editContato(contato).then(
						function(success) {
							
							// apos a inclusao de um
							// contato
							$scope.contatoForm.$setPristine();
							$location.path("/contatos");
						});
				console.log(contato);
			};
			
			var data = contato;
			$scope.contato = data.contato;
			
			
		} ]);