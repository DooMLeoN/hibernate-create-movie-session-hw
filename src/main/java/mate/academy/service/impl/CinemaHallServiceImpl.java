package mate.academy.service.impl;

import javax.persistence.EntityExistsException;
import java.util.List;
import mate.academy.dao.CinemaHallDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.CinemaHall;
import mate.academy.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Inject
    CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall movie) {
        return cinemaHallDao.add(movie);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).orElseThrow(()
                -> new EntityExistsException("Can't get cinema hall by id: " + id));
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}