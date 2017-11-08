require('minitest/autorun')
require('minitest/rg')
require_relative('../bus.rb')
require_relative('../person.rb')
require_relative('../bus_stop.rb')

class TestBus < MiniTest::Test
	def setup
		@bus = Bus.new(27, "Ocean Terminal")
		@person = Person.new("Fraser", 22)
		@person1 = Person.new("Ian", 29)
		@person2 = Person.new("Gillian", 39)
		@not_passenger = Person.new("Jardine", 28)
		@bus_stop = BusStop.new("Grand Central")
		@bus_stop.add_to_queue(@person)
		@bus_stop.add_to_queue(@person1)
		@bus_stop.add_to_queue(@person2)
		@queue = [@person, @person1, @person2]
	end

	def test_has_route_number
		assert_equal(27, @bus.route_number)
	end

	def test_has_destination
		assert_equal("Ocean Terminal", @bus.destination)
	end

	def test_drive
		assert_equal("I am driving to Ocean Terminal.", @bus.drive)
	end

	def test_add_passenger__person_found
		@bus.add_passenger(@person)
		assert_equal(true, @bus.passengers.include?(@person))
	end
	def test_add_passenger__person_not_found
		@bus.add_passenger(@person)
		assert_equal(false, @bus.passengers.include?(@not_passenger))
	end

	def test_drop_off_passenger
		@bus.add_passenger(@person)
		@bus.add_passenger(@person1)

		@bus.drop_off_passenger(@person)
		assert_equal(false, @bus.passengers.include?(@person))
	end
	def test_drop_off_all_passenger
		@bus.add_passenger(@person)

		@bus.drop_off_all_passengers
		assert_equal(0, @bus.passengers.count)
	end

	def test_pickup_all_passengers
		@bus.pickup_all_passengers(@bus_stop)
		assert_equal(@queue, @bus.passengers)
	end

	def test_queue_emptied
		@bus.pickup_all_passengers(@bus_stop)
		assert_equal(0, @bus_stop.queue.count)
	end

end