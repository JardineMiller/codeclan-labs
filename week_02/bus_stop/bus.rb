class Bus
	attr_reader :route_number, :destination, :passengers

	def initialize(route_number, destination)
		@route_number = route_number
		@destination = destination
		@passengers = []
	end

	def drive
		return "I am driving to #{@destination}."
	end

	def add_passenger(person)
		@passengers.push(person)
	end

	def drop_off_passenger(person)
		for passenger in @passengers
			@passengers.delete(passenger) if passenger.name == person.name
		end
	end

	def drop_off_all_passengers
		@passengers = []
	end

	def pickup_all_passengers(bus_stop)
		for person in bus_stop.queue
			add_passenger(person)
		end
		bus_stop.queue = []
	end
end