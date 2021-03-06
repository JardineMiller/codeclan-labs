require_relative('../db/SqlRunner.rb')
require_relative('album.rb')

class Artist
  attr_accessor :name, :id

  def initialize(options)
    @id = options["id"].to_i if options["id"]
    @name = options["name"]
  end

  def save
    sql = "
      INSERT INTO artists (name)
      VALUES ($1)
      RETURNING id
    "
    values = [@name]
    @id = SqlRunner.run(sql,values)[0]['id'].to_i
  end

  def self.all
    sql = "SELECT * FROM artists"
    results = SqlRunner.run(sql)
    return results.map {|artist| Artist.new(artist)}
  end

  def albums
    sql = "SELECT * FROM albums WHERE artist_id = $1"
    values = [@id]
    results = SqlRunner.run(sql, values)
    return results.map{ |album|  Album.new(album)}
  end

  def update
    sql = "
      UPDATE artists
      SET(name) = ($1)
      WHERE id = $2"
    values = [@name, @id]
    SqlRunner.run(sql, values)
  end

  def delete
    sql = "DELETE FROM artists WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def self.find_by_id(id)
    sql = "SELECT * FROM artists WHERE id = $1"
    values = [id]
    result = SqlRunner.run(sql, values)
    return Artist.new(result[0])
  end

  def self.find_by_name(name)
    sql = "SELECT * FROM artists WHERE name = $1"
    values = [name]
    result = SqlRunner.run(sql, values)
    return Artist.new(result[0])
  end
end