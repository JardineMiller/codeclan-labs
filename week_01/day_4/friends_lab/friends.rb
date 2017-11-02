def get_name(person)
  return person[:name]
end

def get_tv_show(person)
	return person[:favourites][:tv_show]
end

def like_food(food, person)
	food_to_compare = person[:favourites][:things_to_eat]
	return true if food = food_to_compare
end

def add_friend(friend, person)
	person[:friends] << friend
	return person[:friends].length
end

def remove_friend(friend, person)
	person[:friends].delete(friend)
	return person[:friends].length
end

def total_money(people)
	total = 0
	for person in people
		total += person[:monies]
	end
	return total
end

def lending_money(person1, person2, amount)
	lender = person1[:monies] - amount
	lendee = person2[:monies] + amount
	result = [lender, lendee]
	return result
end

def all_food(people)
	foods = []
	for person in people
		foods += person[:favourites][:things_to_eat]
	end
	return foods
end

def no_mates(people)
	billy_no_mates = []
	for person in people
		billy_no_mates.push(person[:name]) if person[:friends].length == 0
	end
	return billy_no_mates
end

def same_tv_show(people)
	# show_count = {}
	# tv_check = {} 
	# for person in people
	# 	tv_check[person[:name]] = person[:favourites][:tv_show]
	# end
	# for key, value in tv_check
	# 	show_count[value] = 0
	# end
	# p show_count
	# p tv_check
	# return hash
	 tv_shows = {}
	 result = []

	 for person in people
	 	show = person[:favourites][:tv_show]
	 	
	 	if tv_shows[show]
	 		tv_shows[show].push(person[:name])
	 	else 
	 		tv_shows[show] = [person[:name]]
	 	end
	 end

	 for show in tv_shows.keys
	 	if tv_shows[show].size > 1
	 		result[show] = tv_shows[show]
	 	end
	 end

	 return result
end


