package com.dating.datingApp.service.match;

import com.dating.datingApp.dao.match.MatchDAO;
import com.dating.datingApp.dao.user.UserDAO;
import com.dating.datingApp.exceptions.match.MatchNotFoundException;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.model.Match;
import com.dating.datingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDAO dao;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Match getMatch(int id) {
        Match match = dao.getMatch(id);
        if (match == null) {
            throw new MatchNotFoundException(id);
        }
        return match;
    }

    @Override
    public List<Match> getAllUserMatches(int userId) {
        User user = userDAO.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return dao.getAllUserMatches(userId);
    }

}
