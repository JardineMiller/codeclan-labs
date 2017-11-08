require('minitest/autorun')
require('minitest/rg')
require_relative('../bus.rb')
require_relative('../person.rb')
require_relative('../bus_stop.rb')

class TestBusStop < MiniTest::Test
	def setup
		@bus_stop = BusStop.new("Grand Central")
		@person1 = Person.new("Fraser", 22)
	end

	def test_bus_stop_name
		assert_equal("Grand Central", @bus_stop.name)
	end

	def test_add_passenger_to_queue
		@bus_stop.add_to_queue(@person1)
		assert_equal([@person1], @bus_stop.queue)
	end

end