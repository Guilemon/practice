let http = require('http')

http.createServer(function(req, res){
    res.writeHead(200, {'Content-type':'text/plain'})
    res.end('Hello world\n')
}).listen(2000, '127.0.0.1')

console.log('server running on port 2000')