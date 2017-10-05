//Criando um service com o factory
myApp.factory("contatosAPI", function($http, config) {
	var _getContatos = function() {
		return $http.get(config.baseUrl + "/contatos");
	};

	var _saveContato = function(contato) {
		return $http.post(config.baseUrl + "/contato/save", contato);
	};
	
	var _getContato = function(id){
		return $http.get(config.baseUrl + "/contato/"+id);
	};
	
	var _delContato = function(id){
		return $http.post(config.baseUrl + "/contato/delete", id);
	}

	return {
		getContatos : _getContatos,
		saveContato : _saveContato,
		getContato  : _getContato,
		delContato	: _delContato
	};
});
