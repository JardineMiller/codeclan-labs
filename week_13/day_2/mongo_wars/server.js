const express = require('express');
const parser = require('body-parser');
const server = express();
const MongoClient = require('mongodb').MongoClient;
const ObjectID = require('mongodb').ObjectID;

server.use(parser.json());
server.use(express.static('client/build'));
server.use(parser.urlencoded({extended: true}));

MongoClient.connect('mongodb://localhost:27017', function(err, client) {

  if(err) {
    console.log(err);
    return;
  }

  const db = client.db("star_wars");

  console.log('connected to database');

  server.post('/api/quotes', function(req, res) {
    db.collection('quotes').save(req.body, function(err, result) {
      if(err) {
        console.log(err);
        res.status(500);
        res.send();
      }
      res.status(201);
      res.json(result.ops[0]);
      console.log("saved to database");
    });
  });

  server.get('/api/quotes', function(req, res) {
    db.collection('quotes').find().toArray(function(err, result) {
      if(err) {
        console.log(err);
        res.status(500);
        res.send();
      }
      res.status(201);
      res.json(result);
      console.log("returned database");
    });
  });

  server.delete('/api/quotes', function(req, res) {
    db.collection('quotes').remove(function(err, result) {
      if(err) {
        console.log(err);
        res.status(500);
        res.send();
      }
      res.status(204);
      res.send();
      console.log("deleted");
    });
  });

  server.put('/api/quotes/:id', function(req, res) {
    db.collection('quotes').update({_id: ObjectID(req.params.id)}, req.body, function(err, result) {
      if(err) {
        res.status(500);
        res.send();
      }
      res.status(204);
      res.send();
    })
  })

  server.listen(3000, function(){
    console.log("Listening on port 3000");
  });

});

