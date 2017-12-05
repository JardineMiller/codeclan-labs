require_relative("../db/sql_runner")

class Location 

  attr_reader :id
  attr_accessor :name, :category 

  def initialize( options )
    @id = options['id'].to_i
    @name = options['name']
    @category = options['category']
  end

  def save()
    sql = "INSERT INTO locations 
    (
      name, 
      category
    ) 
    VALUES 
    (
      $1, $2
    ) 
    RETURNING id"
    values = [@name, @category]
    location = SqlRunner.run( sql, values ).first
    @id = location['id'].to_i
  end

  def self.all()
    sql = "SELECT * FROM locations"
    values = []
    locations = SqlRunner.run(sql, values)
    result = locations.map { |location| Location.new( location ) }
    return result
  end

  def self.delete_all() 
    sql = "DELETE FROM locations"
    values = []
    SqlRunner.run(sql, values)
  end

  def self.map_items(users_data)
    result = users_data.map{ |user| User.new(user) }
    return result
  end

  def users
    sql = "
      SELECT users.* FROM users
      INNER JOIN visits
      ON visits.user_id = users.id
      WHERE visits.location_id = $1"
    values = [@id]
    users = SqlRunner.run(sql, values)
    result = self.map_items(users)
    return result
  end



end