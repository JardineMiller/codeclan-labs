require_relative('models/artist.rb')
require_relative('models/album.rb')
require('pp')

# artist = Artist.find_by_name("The Cat Empire")

# # pp artist.albums

# album = Album.find_by_name("Wanted on Voyage")

# pp album

# album.delete

# pp Album.all



# michael_jackson = Artist.new({
#   'name' => 'Michael Jackson'
# })

# the_cat_empire = Artist.new({
#   'name' => 'The Cat Empire'
# })

# paolo_nutini = Artist.new({
#   'name' => 'Paolo Nutini'
# })

# george_ezra = Artist.new({
#   'name' => 'George Ezra'
# })

# michael_jackson.save
# the_cat_empire.save
# paolo_nutini.save
# george_ezra.save

# bad = Album.new({
#   'title' => 'Bad',
#   'artist_id' => michael_jackson.id,
#   'genre' => 'Pop'
# })

# off_the_wall = Album.new({
#   'title' => 'Off The Wall',
#   'artist_id' => michael_jackson.id,
#   'genre' => 'Pop'
# })

# thriller = Album.new({
#   'title' => 'Thriller',
#   'artist_id' => michael_jackson.id,
#   'genre' => 'Pop'
# })

# bad.save
# off_the_wall.save
# thriller.save

# the_cat_empire_album = Album.new({
#   'title' => 'The Cat Empire',
#   'artist_id' => the_cat_empire.id,
#   'genre' => 'Ska'
# })

# two_shoes = Album.new({
#   'title' => 'Two Shoes',
#   'artist_id' => the_cat_empire.id,
#   'genre' => 'Ska'
# })

# lonely_nights = Album.new({
#   'title' => 'Lonely Nights',
#   'artist_id' => the_cat_empire.id,
#   'genre' => 'Ska'
# })

# the_cat_empire_album.save
# two_shoes.save
# lonely_nights.save

# sunny_side_up = Album.new({
#   'title' => 'Sunny Side Up',
#   'artist_id' => paolo_nutini.id,
#   'genre' => 'Folk'
# })

# these_streets = Album.new({
#   'title' => 'These Streets',
#   'artist_id' => paolo_nutini.id,
#   'genre' => 'Folk'
# })

# caustic_love = Album.new({
#   'title' => 'Caustic Love',
#   'artist_id' => paolo_nutini.id,
#   'genre' => 'Folk'
# })

# sunny_side_up.save
# these_streets.save
# caustic_love.save

# wanted_on_voyage = Album.new({
#   'title' => 'Wanted on Voyage',
#   'artist_id' => george_ezra.id,
#   'genre' => 'Folk Pop'
# })

# wanted_on_voyage.save
