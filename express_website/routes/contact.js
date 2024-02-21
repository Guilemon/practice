var express = require('express');
var router = express.Router();
var nodedmailer = require('nodemailer');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('contact',{title:'Contact'});
});

router.post('/send', function(req, res, next){
  var transporter = nodedmailer.createTransport({
    service: 'Gmail',
    auth: {
      user: 'somecompany@gmail.com',
      pass: 'passwordsomething'
    }
  });

  var mailOptions = {
    'from': 'Some company<somecompany@gmail.com>',
    'to': 'somecompany@gmail.com',
    'subject': 'new lead',
    'text': 'you have a new enquiry... Name:,'+req.body.name+' email:'+req.body.email+', message:'+req.body.message,
    'html': `<p>A new enquiry from somecompany's website:
          <p>Name:<span>${req.body.name}</span></p>
          <p>Email:<span>${req.body.email}</span></p>
          <p>Message:<span>${req.body.message}</span></p>
        </p>`
  }

  transporter.sendMail(mailOptions, function(err, info){
    if(err){
      console.log(err)
      res.redirect('/')
    }else{
      console.log('Message sent! info:' + info.response)
      res.redirect('/')
    }
  })
})

module.exports = router;
