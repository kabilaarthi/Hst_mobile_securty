const http = require('http');
const fs = require('fs');
const path = require('path');

const root = path.join(__dirname, 'public');

http.createServer((req, res) => {
  const file = path.join(root,
    req.url === '/' ? 'index.html' : req.url.split('?')[0]
  );

  if (!file.startsWith(root)) {
    res.writeHead(403);
    return res.end('Forbidden');
  }

  fs.readFile(file, (err, data) => {
    if (err) {
      res.writeHead(404);
      return res.end('Not Found');
    }

    const ext = path.extname(file);
    const types = {
      '.html': 'text/html',
      '.css': 'text/css',
      '.js': 'text/javascript'
    };

    res.writeHead(200, {
      'Content-Type': types[ext] || 'text/plain'
    });
    res.end(data);
  });
}).listen(3000, '127.0.0.1', () => {
  console.log('HST Security running at http://127.0.0.1:3000');
});
