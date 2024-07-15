from abc import ABC, abstractmethod

class Piece(ABC):
    @abstractmethod
    def move(self):
        pass

class Queen(Piece):
    def move(self):
        print('Ход ферзя')


b=Queen()
a.move(),b.move()