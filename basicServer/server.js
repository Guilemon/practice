// modules
let http = require('http')
let url = require('url')
let fs = require('fs')
let path = require('path')

// mime types
let mimeTypes = {
    html: 'text/html',
    png: 'image/png',
    jpeg: 'image/jpeg',
    jpg: 'image/jpg',
    'js': 'text/javascript',
    'css': 'text/css'
}

http.createServer(function(req, res){
    let uri = url.parse(req.url).pathname
    let filename = path.join(process.cwd(),unescape(uri))
    let stats

    // console.log()

    try{
        stats = fs.lstatSync(filename)
    }catch(err){
        res.writeHead(404, {'Content-Type':'text/plain'})
        res.end('404 Not Found \n')
        return
    }
    if(stats.isFile()){
        // return file
        let fileExt = mimeTypes[path.extname(filename).split('.').reverse()[0]]
        res.writeHead(200, {'Content-type':fileExt})
        let fileStream = fs.createReadStream(filename)
        fileStream.pipe(res)
    }else if(stats.isDirectory()){
        // redirect to index
        res.writeHead(302, {'Location':'index.html'})
        res.end()
    }else{
        // internal server error
        res.writeHead(500, {'Content-Type':'text/plain'})
        res.write('500 Internal Sever Error')
        res.end()
    }

}).listen(2000, '127.0.0.1')

console.log('server running on port 2000')