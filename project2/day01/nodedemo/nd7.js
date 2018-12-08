var http = require('http');
var url = require('url');
http.createServer(function (request, response) {
    response.writeHead(200,{'Content-Type':'text/plain'});
    var params = url.parse(request.url, true).query;
    response.write('name = ' + params.name);
    response.write('\n');
    response.write('age = ' + params.age);
    response.end();
}).listen(8888);
console.log(('server is running '));