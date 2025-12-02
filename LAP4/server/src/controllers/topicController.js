const topicRepository = require('../repositories/topicRepository');

async function listTopics(req, res, next) {
  try {
    const topics = await topicRepository.getTopicsWithStories();
    res.json(topics);
  } catch (error) {
    next(error);
  }
}

async function getTopic(req, res, next) {
  try {
    const topic = await topicRepository.getTopicById(req.params.id);
    if (!topic) {
      return res.status(404).json({ message: 'Topic not found' });
    }
    return res.json(topic);
  } catch (error) {
    return next(error);
  }
}

async function getStory(req, res, next) {
  try {
    const story = await topicRepository.getStoryById(req.params.id);
    if (!story) {
      return res.status(404).json({ message: 'Story not found' });
    }
    return res.json(story);
  } catch (error) {
    return next(error);
  }
}

module.exports = {
  listTopics,
  getTopic,
  getStory
};

