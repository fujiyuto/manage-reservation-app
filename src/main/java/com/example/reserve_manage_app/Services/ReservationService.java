package com.example.reserve_manage_app.Services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reserve_manage_app.Entities.ReservationEntity;
import com.example.reserve_manage_app.Exceptions.DataInsertException;
import com.example.reserve_manage_app.Exceptions.DataUpdateException;
import com.example.reserve_manage_app.Mapper.ReservationMapper;
import com.example.reserve_manage_app.dto.requests.CreateReservationRequest;
import com.example.reserve_manage_app.dto.requests.UpdateReservationRequest;
import com.example.reserve_manage_app.dto.requests.UpdateReservationStatusRequest;
import com.example.reserve_manage_app.dto.responses.ApiResponse;
import com.example.reserve_manage_app.dto.responses.GetRestaurantReservationResponse;
import com.example.reserve_manage_app.dto.responses.GetUserReservationResponse;
import com.example.reserve_manage_app.dto.responses.UpdateReservationResponse;

@Service
public class ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;

    /**
     * ユーザーIDを受け取り、ユーザーの予約データの一覧を取得する。
     * 
     * @param  Long                       userId   ユーザーID
     * @return GetUserReservationResponse response レスポンス
     */
    public GetUserReservationResponse getUserReservationData(Long userId) {
        // ユーザーの予約データ取得処理
        List<ReservationEntity> reservationList = reservationMapper.getUserReservationData(userId);

        // レスポンス返却
        GetUserReservationResponse response = new GetUserReservationResponse(reservationList);
        return response;
    }

    /**
     * 店IDを受け取り、店の予約データの一覧を取得する。
     * 
     * @param  Long                             restaurantId 店ID
     * @return GetRestaurantReservationResponse response     レスポンス
     */
    public GetRestaurantReservationResponse getRestaurantReservationData(Long restaurantId) {
        // 店の予約データ取得処理
        List<ReservationEntity> reservationList = reservationMapper.getRestaurantReservationData(restaurantId);

        // レスポンス返却
        GetRestaurantReservationResponse response = new GetRestaurantReservationResponse(reservationList);
        return response;
    }

    /**
     * 予約データ作成のリクエストを受け取り、予約データを作成する。
     * 
     * @param  CreateReservationRequest request  予約登録リクエスト
     * @return ApiResponse              response レスポンス
     * @throws SQLException
     */
    public ApiResponse insertReservation(CreateReservationRequest request) throws DataInsertException {
        // 予約データ作成処理
        int numOfInsertRecord = reservationMapper.createReservation(
            request.getUserId(),
            request.getRestaurantId(),
            request.getReserveDatetime(),
            request.getNumberOfPeople(),
            request.getNotes()
        );

        // データ作成に失敗した時はエラー
        if ( numOfInsertRecord != 1 ) {
            throw new DataInsertException("予約データの作成に失敗しました。");
        }

        // レスポンス返却
        return new ApiResponse("予約が完了しました。");
    }

    /**
     * 予約IDと予約データ更新のリクエストを受け取り、予約データの内容を更新する。
     * 
     * @param  Long                     reservationId 予約ID
     * @param  UpdateReservationRequest request       予約データ更新リクエスト
     * @return 
     */
    @Transactional
    public UpdateReservationResponse updateReservation(Long reservationId, UpdateReservationRequest request) throws DataUpdateException {
        // 予約データ更新処理
        int numOfUpdateRecord = reservationMapper.updateReservation(
                                    reservationId,
                                    request.getReserveDatetime(),
                                    request.getNumberOfPeople(),
                                    request.getNotes()
                                );
        
        // 更新件数が1でない場合はエラー
        if ( numOfUpdateRecord != 1 ) {
            throw new DataUpdateException("予約内容の更新に失敗しました。");
        }

        // 予約データを取得
        ReservationEntity reservation = reservationMapper.getReservationData(reservationId);

        UpdateReservationResponse response = new UpdateReservationResponse(reservation);
        return response;
    }

    /**
     * 予約IDと予約状況更新のリクエストを受け取り、予約データの状況を更新する。
     * 
     * @param  Long                           reservationId 予約ID
     * @param  UpdateReservationStatusRequest request       予約状況更新リクエスト
     * @return
     * @throws Exception
     */
    public UpdateReservationResponse updateReservationStatus(Long reservationId, UpdateReservationStatusRequest request) throws Exception {
        // 予約状況の更新
        int numOfUpdateRecord = reservationMapper.updateReservationStatus(
                                    reservationId,
                                    request.getStatus()
                                );

        // 更新件数が1でない場合はエラー
        if ( numOfUpdateRecord != 1 ) {
            throw new DataUpdateException("予約内容の更新に失敗しました。");
        }

        // 予約データを取得
        ReservationEntity reservation = reservationMapper.getReservationData(reservationId);

        UpdateReservationResponse response = new UpdateReservationResponse(reservation);
        return response;
    }
}
