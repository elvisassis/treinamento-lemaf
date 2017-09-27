//Criando um service com o factory
myApp.factory("contatosAPI", function($http, config) {
	var _getContatos = function() {
		return $http.get(config.baseUrl + "/contatos");
	};

	var _saveContato = function(contatos) {
		return $http.post(config.baseUrl + "/contatos/save", contatos);
	};

	return {
		getContatos : _getContatos,
		saveContato : _saveContato
	};
});

/*.then(function(success){
return success;
},function(error){
return "não foi possivel carregar os contatos";
});*/