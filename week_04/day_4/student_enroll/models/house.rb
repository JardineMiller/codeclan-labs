class House
  attr_reader :id, :name, :logo_url

  def initialize(options)
    @id = options["id"].to_i if options["id"]
    @logo_url = options["logo_url"]
    @name = options["name"]
  end

    def save
    sql = "
    INSERT INTO houses 
    (name, logo_url)
    VALUES ($1, $2)
    RETURNING id
    "
    values = [@name, @logo_url]
    house = SqlRunner.run(sql, values).first
    @id = house["id"].to_i
  end

  def self.all
    sql = "
    SELECT * FROM houses
    "
    result = SqlRunner.run(sql)
    houses = result.map { |house| House.new(house) }
    return houses
  end

  def self.find(id)
    sql = "
    SELECT * FROM houses
    WHERE id = $1
    "
    values = [id]
    result = SqlRunner.run(sql, values).first
    return House.new(result)
  end

end