require('sinatra')
require('sinatra/reloader')

require_relative('models/student.rb')
require_relative('models/house.rb')

get '/students' do
  @students = Student.all
  erb :index
end

post '/students' do
  @student = Student.new(params)
  @student.save
  redirect to '/students'
end

get '/students/new' do
  @houses = House.all
  erb :new
end

get '/students/:id' do
  @student = Student.find(params[:id])
  erb :show
end

get '/students/:id/edit' do
  @student = Student.find(params[:id])
  @houses = House.all
  erb :edit
end

put '/students/:id' do
  Student.new(params).update
  redirect to '/students'
end

delete '/students/:id' do
  student = Student.find(params[:id])
  student.delete
  redirect to '/students'
end
