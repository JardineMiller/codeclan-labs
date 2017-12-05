require('pry-byebug')
require_relative('../models/student.rb')
require_relative('../models/house.rb')

house1 = House.new ({"name" => "Fire", "logo_url" => "http://boardgame.design/wp-content/uploads/2015/09/element-icon-fire.png"})
house2 = House.new ({"name" => "Earth", "logo_url" => "http://boardgame.design/wp-content/uploads/2015/09/element-icon-earth.png"})
house3 = House.new ({"name" => "Wind", "logo_url" => "http://boardgame.design/wp-content/uploads/2015/09/element-icon-air.png"})
house4 = House.new ({"name" => "Water", "logo_url" => "http://boardgame.design/wp-content/uploads/2015/09/element-icon-water.png"})

house1.save
house2.save
house3.save
house4.save

student1 = Student.new({
  "first_name" => "Jardine",
  "last_name" => "Miller",
  "portrait_url" => "https://picsum.photos/200",
  "house_id" => house1.id,
  "age" => 28
  })

student2 = Student.new({
  "first_name" => "Ian",
  "last_name" => "Henderson",
  "portrait_url" => "https://picsum.photos/200",
  "house_id" => house2.id,
  "age" => 28
  })

student3 = Student.new({
  "first_name" => "Julia",
  "last_name" => "Pogust",
  "portrait_url" => "https://picsum.photos/200",
  "house_id" => house3.id,
  "age" => 27
  })

student4 = Student.new({
  "first_name" => "Sam",
  "last_name" => "Watkins",
  "portrait_url" => "https://picsum.photos/200",
  "house_id" => house4.id,
  "age" => 30
  })

student1.save
student2.save
student3.save
student4.save

# binding.pry
# nil