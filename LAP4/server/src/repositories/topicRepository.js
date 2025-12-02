const pool = require('../db/pool');

async function getTopicsWithStories() {
  const connection = await pool.getConnection();
  try {
    const [topicRows] = await connection.query(
      'SELECT id, title, emoji, description, sort_order FROM topics ORDER BY sort_order ASC'
    );
    const [storyRows] = await connection.query(
      'SELECT id, topic_id, title, content, position FROM stories ORDER BY position ASC'
    );

    const storyMap = storyRows.reduce((acc, story) => {
      if (!acc[story.topic_id]) {
        acc[story.topic_id] = [];
      }
      acc[story.topic_id].push({
        id: story.id,
        title: story.title,
        content: story.content
      });
      return acc;
    }, {});

    return topicRows.map((topic) => ({
      id: topic.id,
      title: topic.title,
      emoji: topic.emoji,
      description: topic.description,
      stories: storyMap[topic.id] || []
    }));
  } finally {
    connection.release();
  }
}

async function getTopicById(id) {
  const [rows] = await pool.query('SELECT id, title, emoji, description FROM topics WHERE id = ?', [id]);
  if (!rows.length) {
    return null;
  }
  const [stories] = await pool.query(
    'SELECT id, topic_id, title, content FROM stories WHERE topic_id = ? ORDER BY position ASC',
    [id]
  );
  return {
    ...rows[0],
    stories
  };
}

async function getStoryById(id) {
  const [rows] = await pool.query('SELECT id, topic_id, title, content FROM stories WHERE id = ?', [id]);
  return rows.length ? rows[0] : null;
}

module.exports = {
  getTopicsWithStories,
  getTopicById,
  getStoryById
};

