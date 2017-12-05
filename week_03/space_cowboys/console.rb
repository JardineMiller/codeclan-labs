require('pry-byebug')
require('pp')
require_relative('models/bounties.rb')

jimmy = Bounty.new({
  "name" => "Jimmy Snaggletooth",
  "bounty_value" => "500",
  "danger_level" => "high",
  "fav_weapon" => "shiv"
})

monty = Bounty.new({
  "name" => "Monty Lazerface",
  "bounty_value" => "5000",
  "danger_level" => "extreme",
  "fav_weapon" => "lazer"
})

fluffy = Bounty.new({
  "name" => "Fluffy McScruffles",
  "bounty_value" => "5",
  "danger_level" => "low",
  "fav_weapon" => "cuddles"
})

tom = Bounty.new({
  "name" => "Tom Cruise",
  "bounty_value" => "250",
  "danger_level" => "low",
  "fav_weapon" => "scientology"
})


# @fluffy.save
# @fluffy.save
# @fluffy.delete

# @monty.save
# @tom.save

# pp Bounty.find_by_id(8)
pp Bounty.find_by_name("Tom Cruise")