const express = require('express');
const topicController = require('../controllers/topicController');

const router = express.Router();

router.get('/topics', topicController.listTopics);
router.get('/topics/:id', topicController.getTopic);
router.get('/stories/:id', topicController.getStory);

module.exports = router;

