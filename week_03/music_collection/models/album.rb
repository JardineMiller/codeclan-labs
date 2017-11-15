require_relative('../db/SqlRunner.rb')

class Album
  attr_accessor :title, :id, :artist_id

  def initialize(options)
    @title = options['title']
    @id = options['id'].to_i if options['id']
    @artist_id = options['artist_id']
    @genre = options['genre']
  end

  def save
   sql = "
          INSERT INTO albums(title, genre, artist_id)
          VALUES($1, $2, $3)
          RETURNING id
    "
    values = [@title, @genre, @artist_id]
    @id = SqlRunner.run(sql,values)[0]['id'].to_i
  end

  def self.all
    sql = "SELECT * FROM albums"
    result = SqlRunner.run(sql)
    result.map { |album| Album.new(album) }
  end

  def artist
    sql = "SELECT * FROM artists WHERE id = $1"
    values = [@artist_id]
    result = SqlRunner.run(sql,values)[0]
    Artist.new(result)
  end

  def update
    sql = "UPDATE albums SET(title,genre) = ($1,$2) WHERE id = $3"
    values = [@title,@genre,@id]
    SqlRunner.run(sql,values)
  end

  def delete
    sql = "DELETE FROM albums WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql,values)
  end

  def self.find_by_id(id)
    sql = "SELECT * FROM albums WHERE id = $1"
    values = [id]
    result = SqlRunner.run(sql,values)
    return Album.new(result[0])
  end
end