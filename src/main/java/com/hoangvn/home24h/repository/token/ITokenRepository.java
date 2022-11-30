package com.hoangvn.home24h.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangvn.home24h.models.token.Token;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Long> {
    Token findByTokenString(String token);
}
