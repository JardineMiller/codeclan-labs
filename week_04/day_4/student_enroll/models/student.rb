require_relative('../db/sqlrunner.rb')
require_relative('../models/house.rb')

class Student
  attr_accessor :id, :first_name, :last_name, :house_id, :age, :portrait_url

  def initialize(options)
    @id = options["id"].to_i if options["id"]    
    @first_name = options["first_name"]
    @last_name = options["last_name"]
    @portrait_url = options["portrait_url"]
    @house_id = options["house_id"].to_i
    @age = options["age"].to_i
  end

  def full_name
    return "#{@first_name} #{@last_name}"
  end

  def save
    sql = "
    INSERT INTO students 
    (first_name, last_name, portrait_url, house_id, age)
    VALUES ($1, $2, $3, $4, $5)
    RETURNING id
    "
    values = [@first_name, @last_name, @portrait_url, @house_id, @age]
    result = SqlRunner.run(sql, values).first
    @id = result["id"].to_i
  end

  def update
    sql = "
    UPDATE students
    SET (first_name, last_name, house_id, age) =
        ($1, $2, $3, $4)
    WHERE id = $5
    "
    values = [@first_name, @last_name, @house_id, @age, @id]
    SqlRunner.run(sql, values)
  end

  def delete
    sql = "DELETE FROM students 
    WHERE id = $1"
    values = [@id]
    SqlRunner.run( sql, values )
  end

  def house
    sql = "
    SELECT houses.* FROM students
    INNER JOIN houses
    ON students.house_id = houses.id
    WHERE students.id = $1
    "
    values = [@id]
    result = SqlRunner.run(sql, values).first
    return House.new(result)
  end

  def self.find(id)
    sql = "
    SELECT * FROM students
    WHERE id = $1
    "
    values = [id]
    result = SqlRunner.run(sql, values).first
    return Student.new(result)
  end

  def self.all
    sql = "
    SELECT * FROM students ORDER BY id
    "
    result = SqlRunner.run(sql)
    students = result.map { |student| Student.new(student) }
    return students
  end

end