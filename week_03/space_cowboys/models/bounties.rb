require('pg')

class Bounty

  attr_accessor :id, :name, :bounty_value, :danger_level, :fav_weapon

  def initialize(details)
    @id = details["id"].to_i if details["id"]
    @name = details["name"]
    @bounty_value = details["bounty_value"].to_i
    @danger_level = details["danger_level"]
    @fav_weapon = details["fav_weapon"]
  end

  def save
    # Create connection
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    # Save SQL query to a variable
    sql = "
    INSERT INTO bounties (
      name,
      bounty_value,
      danger_level,
      fav_weapon
    )
    VALUES (
      $1, $2, $3, $4
    )
    RETURNING *
    "
    values = [@name, @bounty_value, @danger_level, @fav_weapon]
    db.prepare("save", sql)
    # Execute SQL
    @id = db.exec_prepared("save", values)[0]["id"].to_i
    # Close our DB connection
    db.close
  end

  def delete
    # Create connection
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    # Save SQL query to a variable
    sql = "
      DELETE FROM bounties WHERE id = $1
    "
    values = [@id]
    db.prepare("delete", sql)
    # Execute SQL
    db.exec_prepared("delete", values)
    #  # Close our DB connection
    db.close
  end

  def update 
    # Create connection
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    # Save SQL query to a variable
    sql = "
      UPDATE bounties 
      SET (name, bounty_value, danger_level, fav_weapon) = 
      ($1, $2, $3, $4)
      WHERE id = $5
     "
    values = [@name, @bounty_value, @danger_level, @fav_weapon, @id]
    db.prepare("update", sql)
    # Execute SQL
    db.exec_prepared("update", values)
    #  # Close our DB connection
    db.close
  end

  def self.find(id)
    # Create connection
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    # Save SQL query to a variable
    sql = 
    "
    SELECT * FROM bounties WHERE id = $1
    "
    values = [id]
    db.prepare("find", sql)
    # Execute SQL
    result = db.exec_prepared("find", values)
    #  # Close our DB connection
    db.close
    
    return result.map { |bounty| Bounty.new(bounty) }
  end

end
